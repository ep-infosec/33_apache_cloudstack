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

<template>
  <a-popconfirm
    :title="`${$t('label.delete.rule')}?`"
    @confirm="handleDelete"
    :disabled="disabled">
    <tooltip-button
      :tooltip="$t('label.delete.rule')"
      tooltipPlacement="bottom"
      type="primary"
      :danger="true"
      icon="delete-outlined"
      :disabled="disabled" />
  </a-popconfirm>
</template>

<script>
import TooltipButton from '@/components/widgets/TooltipButton'

export default {
  name: 'RuleDelete',
  components: {
    TooltipButton
  },
  props: {
    record: {
      type: Object,
      required: true
    },
    disabled: {
      type: Boolean,
      default: false
    }
  },
  methods: {
    handleDelete () {
      this.$emit('delete')
    }
  }
}
</script>

<style
  scoped
  lang="scss"
>
  .anticon-delete {
    display: flex;
    align-items: center;
    justify-content: center;
  }
</style>
