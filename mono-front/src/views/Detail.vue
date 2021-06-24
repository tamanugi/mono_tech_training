<template>
<div>
  <v-alert
    v-if="alert"
    border="left"
    color="green"
    dense
    icon="mdi-account"
    outlined
    type="success"
  >edit success</v-alert>

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

    <v-card-text>
      <v-text-field label="id" :value="user.id" disabled></v-text-field>
      <v-text-field
        label="name"
        v-model="user.name"
        append-icon="mdi-pencil"
        ></v-text-field>
    </v-card-text>

    <v-card-text>
      <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. </div>
    </v-card-text>

    <v-divider></v-divider>

    <v-card-actions>
      <v-spacer></v-spacer>
      <v-btn
        color="primary"
        text
        :loading="edit_loading"
        :disabled="edit_loading"
        @click="update()"
      >
        EDIT
      </v-btn>
    </v-card-actions>
  </v-card>
</div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import { User } from '@/types'
import { findById, updateUser } from '@/repositories/user'

@Component
export default class Detail extends Vue {
  user: User = {name: '', id: ''};
  loading = true;
  alert = false;
  edit_loading = false;

  created() {
    // load data from server
    findById(this.$route.params.id)
      .then(user => {
        this.loading = false
        if(user) this.user = user;
      })
  }

  update() {
    this.edit_loading = true;
    updateUser(this.user)
      .then(data => {
        this.user = data;
        this.edit_loading = false;

        this.alert = true;

        setTimeout(() => {
          this.alert = false;
        }, 2000)
      })
  }
}
</script>