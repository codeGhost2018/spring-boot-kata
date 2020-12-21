package com.tim.kata.config;

import com.tim.kata.dao.MetricMapper;
import com.tim.kata.enums.EventEnum;
import com.tim.kata.enums.StateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.transition.Transition;
import org.springframework.stereotype.Component;

@Component
public class StateMachineListener extends StateMachineListenerAdapter<StateEnum, EventEnum> {



    @Override
    public void stateChanged(State<StateEnum, EventEnum> from, State<StateEnum, EventEnum> to) {
        System.out.printf("Transitioned from %s to %s%n", from == null ? "none" : from.getId(), to.getId());

    }

    @Override
    public void transitionEnded(Transition<StateEnum, EventEnum> transition) {
        super.transitionEnded(transition);
    }
}