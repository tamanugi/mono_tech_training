<template>
<div>
  <dl v-if="user">
    <dt>User Id</dt>
    <dd>{{user.id}}</dd>
    <dt>User Name</dt>
    <dd>{{user.name}}</dd>
  </dl>
  <div v-if="loaded && !user">該当のユーザは見つかりませんでした。</div>
</div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import { User } from '@/types'
import { findById } from '@/repositories/user'

@Component
export default class Detail extends Vue {
  user: User | null = null;
  loaded = false;

  created() {
    // load data from server
    findById(this.$route.params.id)
      .then(user => {
        this.loaded = true
        this.user = user;
      })
  }
}
</script>