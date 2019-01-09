package com.sds.customer.config;

import org.axonframework.common.transaction.TransactionManager;
import org.axonframework.eventsourcing.EventCountSnapshotTriggerDefinition;
import org.axonframework.eventsourcing.SnapshotTriggerDefinition;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.annotation.ParameterResolverFactory;
import org.axonframework.spring.eventsourcing.SpringAggregateSnapshotter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
public class AxonConfig {

    @Bean
    public SpringAggregateSnapshotter snapshotter(ParameterResolverFactory parameterResolverFactory,
                                                  EventStore eventStore,
                                                  TransactionManager transactionManager) {
        // https://docs.axoniq.io/reference-guide/v/3.3/part-iii-infrastructure-components/repository-and-event-store#snapshotting
        // (...) By default, snapshots are created in the thread that calls the scheduleSnapshot() method, which is generally not recommended for production (...)
        Executor executor = Executors.newSingleThreadExecutor();
        return SpringAggregateSnapshotter.builder()
                .eventStore(eventStore)
                .parameterResolverFactory(parameterResolverFactory)
                .transactionManager(transactionManager)
                .build();
//        return new SpringAggregateSnapshotter(eventStore, parameterResolverFactory, executor, transactionManager);
    }


    @Bean
    public SnapshotTriggerDefinition eventCountSnapshotTriggerDefinition(SpringAggregateSnapshotter snapshotter) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, 3);
    }
}
