/**
 * Copyright (C) 2015 The Gravitee team (http://gravitee.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gravitee.gateway.core.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.gravitee.gateway.api.Repository;
import io.gravitee.gateway.core.Reactor;
import io.gravitee.gateway.core.event.EventManager;
import io.gravitee.gateway.core.event.impl.EventManagerImpl;
import io.gravitee.gateway.core.handler.ErrorHandler;
import io.gravitee.gateway.core.handler.Handler;
import io.gravitee.gateway.core.reactor.AsyncGraviteeReactor;
import io.gravitee.gateway.core.repository.FileRepository;
import io.gravitee.gateway.core.service.ApiService;
import io.gravitee.gateway.core.service.impl.ApiServiceImpl;

/**
 * @author David BRASSELY (brasseld at gmail.com)
 */
@Configuration
public class CoreConfiguration {

    @Bean
    public Reactor reactor() {
        return new AsyncGraviteeReactor();
    }

    @Bean
    public Repository repository() {
        return new FileRepository();
    }

    @Bean
    public EventManager eventManager() {
        return new EventManagerImpl();
    }

    @Bean
    public ApiService apiService() {
        return new ApiServiceImpl();
    }

    @Bean(name = "errorHandler")
    public Handler errorHandler() {
        return new ErrorHandler();
    }
}