<template>
  <v-app>
    <v-app-bar
      app
      color="primary"
      dark
    >
      <div class="container">
        <div class="d-flex align-center" style="width: 1000px">
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
      </div>
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
.container {
  width: auto;
  max-width: 1000px;
  margin: 0 auto;
}

</style>