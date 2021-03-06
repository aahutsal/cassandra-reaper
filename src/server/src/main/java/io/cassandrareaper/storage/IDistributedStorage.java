/*
 * Copyright 2017-2017 Spotify AB
 * Copyright 2017-2018 The Last Pickle Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.cassandrareaper.storage;

import io.cassandrareaper.core.NodeMetrics;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


/**
 * Definition for a storage that can run in distributed (peer-to-peer) mode. For example Cassandra.
 */
public interface IDistributedStorage {

  boolean takeLead(UUID leaderId);

  boolean renewLead(UUID leaderId);

  List<UUID> getLeaders();

  void releaseLead(UUID leaderId);

  void forceReleaseLead(UUID leaderId);

  int countRunningReapers();

  void saveHeartbeat();

  Collection<NodeMetrics> getNodeMetrics(UUID runId);

  Optional<NodeMetrics> getNodeMetrics(UUID runId, String node);

  void deleteNodeMetrics(UUID runId, String node);

  void storeNodeMetrics(UUID runId, NodeMetrics nodeMetrics);

}
