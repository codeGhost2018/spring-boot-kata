package com.tim.kata.compose;


import com.tim.kata.config.StateMachineInterceptor;
import com.tim.kata.entity.Metric;
import com.tim.kata.enums.EventEnum;
import com.tim.kata.enums.StateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.support.DefaultStateMachineContext;
import org.springframework.stereotype.Component;

@Component
public class SimpleStateMachineCompose {

    @Autowired
    private StateMachineInterceptor interceptor;

    @Autowired
    private StateMachineFactory<StateEnum, EventEnum> stateMachineFactory;


    public StateMachine<StateEnum, EventEnum> restoreStateMachine(Metric metric) {
        StateEnum stateEnum = StateEnum.valueOf(metric.getState());
        StateMachine<StateEnum, EventEnum> stateMachine = stateMachineFactory.getStateMachine(metric.getId().toString());
        stateMachine.stop();
        stateMachine.getStateMachineAccessor().doWithAllRegions(access -> {
            access.addStateMachineInterceptor(interceptor);
            access.resetStateMachine(new DefaultStateMachineContext<StateEnum, EventEnum>(stateEnum, null, null, null));
        });
        stateMachine.start();
        return stateMachine;
    }
}
