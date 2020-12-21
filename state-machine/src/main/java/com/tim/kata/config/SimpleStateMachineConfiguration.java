package com.tim.kata.config;

import com.tim.kata.enums.EventEnum;
import com.tim.kata.enums.StateEnum;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
@EnableStateMachineFactory
public class SimpleStateMachineConfiguration extends StateMachineConfigurerAdapter<StateEnum, EventEnum> {


    @Override
    public void configure(StateMachineConfigurationConfigurer<StateEnum, EventEnum> config) throws Exception {
        config.withConfiguration().listener(new StateMachineListener());
    }

    @Override
    public void configure(StateMachineStateConfigurer<StateEnum, EventEnum> states) throws Exception {

        states.withStates().initial(StateEnum.VS).end(StateEnum.VE)
                .states(new HashSet<>(Arrays.asList(StateEnum.V1, StateEnum.V2, StateEnum.V3)));


    }

    @Override
    public void configure(StateMachineTransitionConfigurer<StateEnum, EventEnum> transitions) throws Exception {

        transitions.withExternal()
                .action(initAction())
                .source(StateEnum.VS).target(StateEnum.V1).event(EventEnum.START)
                .action(initEndAction())
                .and().withExternal()
                .source(StateEnum.V1).target(StateEnum.V2).event(EventEnum.UP_LEVEL)
                .and().withExternal()
                .source(StateEnum.V2).target(StateEnum.V3).event(EventEnum.RESTART)
                .and().withExternal()
                .source(StateEnum.V3).target(StateEnum.VE).event(EventEnum.FINAL).action(endAction());
    }


    @Bean
    public Action<StateEnum, EventEnum> initAction() {
        return new Action<StateEnum, EventEnum>() {

            @Override
            public void execute(StateContext<StateEnum, EventEnum> context) {
                String id = context.getStateMachine().getId();

            }
        };
//        return ctx -> System.out.println("INIT ACTION" + ctx.getTarget().getId());
    }

    @WithStateMachine
    @Bean
    public Action<StateEnum, EventEnum> initEndAction() {
        return ctx -> System.out.println("INIT END ACTION" + ctx.getTarget().getId());
    }

    @Bean
    public Action<StateEnum, EventEnum> endAction() {
        return ctx -> System.out.println("END ACTION" + ctx.getTarget().getId());
    }



}
