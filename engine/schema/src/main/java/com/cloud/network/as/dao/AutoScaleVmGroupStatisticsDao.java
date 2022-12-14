// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.
package com.cloud.network.as.dao;

import java.util.Date;
import java.util.List;

import com.cloud.network.as.AutoScaleVmGroupStatisticsVO;
import com.cloud.utils.db.GenericDao;

public interface AutoScaleVmGroupStatisticsDao extends GenericDao<AutoScaleVmGroupStatisticsVO, Long> {
    boolean removeByGroupId(long vmGroupId);

    boolean removeByGroupId(long vmGroupId, Date beforeDate);

    boolean removeByGroupAndPolicy(long vmGroupId, long policyId, Date beforeDate);

    List<AutoScaleVmGroupStatisticsVO> listDummyRecordsByVmGroup(long vmGroupId, Date afterDate);

    List<AutoScaleVmGroupStatisticsVO> listInactiveByVmGroupAndPolicy(long vmGroupId, long policyId, Date afterDate);

    List<AutoScaleVmGroupStatisticsVO> listByVmGroupAndPolicyAndCounter(long vmGroupId, long policyId, long counterId, Date afterDate);

    void updateStateByGroup(Long groupId, Long policyId, AutoScaleVmGroupStatisticsVO.State state);

    AutoScaleVmGroupStatisticsVO createInactiveDummyRecord(Long groupId);
}
