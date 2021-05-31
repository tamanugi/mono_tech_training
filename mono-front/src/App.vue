<template>
  <v-app class="app-wrapper">
    <v-app-bar
      app
      color="primary"
      dark
    >
      <div class="d-flex align-center">
        <v-img
          alt="Vuetify Logo"
          class="shrink mr-2"
          contain
          src="https://cdn.vuetifyjs.com/images/logos/vuetify-logo-dark.png"
          transition="scale-transition"
          width="40"
        />

        <span>USER SEARCH</span>
      </div>


      <v-spacer></v-spacer>
    </v-app-bar>
    <v-main>
      <v-container class="container">
        <router-view/>
      </v-container>
    </v-main>
  </v-app>
</template>

<script lang="ts">
import Vue from 'vue';

export default Vue.extend({
  name: 'App',

  data: () => ({
    //
  }),
});
</script>

<style scoped>
.app-wrapper {
  margin-left: 100px;
}

</style>