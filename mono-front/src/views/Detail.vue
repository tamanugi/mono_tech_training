<template>
  <v-card
    :loading="loading"
    class="mx-auto my-12"
    max-width="374"
  >
    <template slot="progress">
      <v-progress-linear
        color="deep-purple"
        height="10"
        indeterminate
      ></v-progress-linear>
    </template>

    <v-img
      height="250"
      src="https://picsum.photos/600/400"
    ></v-img>

    <v-card-title>{{user.id}} {{user.name}}</v-card-title>

    <v-card-text>
      <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. </div>
    </v-card-text>
  </v-card>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import { User } from '@/types'
import { findById } from '@/repositories/user'

@Component
export default class Detail extends Vue {
  user: User = {name: '', id: ''};
  loading = true;

  created() {
    // load data from server
    findById(this.$route.params.id)
      .then(user => {
        this.loading = false
        if(user) this.user = user;
      })
  }
}
</script>