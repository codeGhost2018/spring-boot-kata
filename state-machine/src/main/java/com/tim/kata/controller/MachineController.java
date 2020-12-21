package com.tim.kata.controller;

import com.tim.kata.compose.SimpleStateMachineCompose;
import com.tim.kata.dao.MetricMapper;
import com.tim.kata.entity.Metric;
import com.tim.kata.enums.EventEnum;
import com.tim.kata.enums.StateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/machine")
public class MachineController {

    @Autowired
    private MetricMapper metricMapper;

    @Autowired
    private SimpleStateMachineCompose simpleStateMachineCompose;

//    @PostConstruct
//    public void init() {
//        stateMachine = stateMachineFactory.getStateMachine("id");
//    }

    @GetMapping("/runEvent")
    public String runEvent(@RequestParam("id") Long id, @RequestParam("event") String event) {
        Metric metric = getOrCreateMetric(id);

        StateMachine<StateEnum, EventEnum> stateMachine = simpleStateMachineCompose.restoreStateMachine(metric);
        Message<EventEnum> message = MessageBuilder
                .withPayload(EventEnum.valueOf(event))
                .setHeader("OBJECT", metric)
                .build();
        stateMachine.sendEvent(message);
        return stateMachine.toString();
    }

    @GetMapping("/getState")
    public String getState(@RequestParam("id") Long id) {
        Metric metric = getOrCreateMetric(id);
        StateMachine<StateEnum, EventEnum> stateMachine = simpleStateMachineCompose.restoreStateMachine(metric);
        return stateMachine.toString();
    }



    private Metric getOrCreateMetric(Long id) {
        Metric metric = null;
        if(id == null) {
            metric = new Metric();
            metric.setState(StateEnum.VS.name());
            metric.setMainMetric("小仓库");
            metric.setUserId("tim.zl");
            this.metricMapper.insertSelective(metric);
        }else {
            metric = this.metricMapper.selectById(id);
        }
        return metric;
    }
}
