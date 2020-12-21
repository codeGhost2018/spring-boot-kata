package com.tim.kata.config;

import com.tim.kata.dao.MetricMapper;
import com.tim.kata.entity.Metric;
import com.tim.kata.enums.EventEnum;
import com.tim.kata.enums.StateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.support.StateMachineInterceptorAdapter;
import org.springframework.statemachine.transition.Transition;
import org.springframework.stereotype.Component;

@Component
public class StateMachineInterceptor extends StateMachineInterceptorAdapter<StateEnum, EventEnum> {

    @Autowired
    private MetricMapper metricMapper;

    @Override
    public void postStateChange(State<StateEnum, EventEnum> state, Message<EventEnum> message, Transition<StateEnum, EventEnum> transition, StateMachine<StateEnum, EventEnum> stateMachine) {
        Object object = message.getHeaders().get("OBJECT");
        if(object == null) {
            return;
        }
        Metric metric = (Metric) object;
        metric.setState(state.getId().name());
        metric.setSubMetric(transition.getTrigger().getEvent().name());
        metricMapper.updateById(metric, metric.getId());
    }

}
