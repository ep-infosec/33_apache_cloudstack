#!/bin/bash
# Licensed to the Apache Software Foundation (ASF) under one
# or more contributor license agreements.  See the NOTICE file
# distributed with this work for additional information
# regarding copyright ownership.  The ASF licenses this file
# to you under the Apache License, Version 2.0 (the
# "License"); you may not use this file except in compliance
# with the License.  You may obtain a copy of the License at
#
#   http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing,
# software distributed under the License is distributed on an
# "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
# KIND, either express or implied.  See the License for the
# specific language governing permissions and limitations
# under the License.
#
# This script should be responsible for bring up the
# test environment and executing the tests.
#

mkdir -p integration-test-results/smoke/misc
mkdir -p integration-test-results/component

TESTS=($@)
echo "Running tests: " ${TESTS[@]}

set -e

for suite in "${TESTS[@]}" ; do
  echo "Currently running test: $suite"
  time nosetests-3.4 --with-xunit --xunit-file=integration-test-results/$suite.xml --with-marvin --marvin-config=setup/dev/advanced.cfg test/integration/$suite.py -s -a tags=advanced,required_hardware=false --zone=Sandbox-simulator --hypervisor=simulator || true ;
done

python3 ./tools/travis/xunit-reader.py integration-test-results/
