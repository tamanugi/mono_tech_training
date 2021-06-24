<template>
  <v-app>
    <v-app-bar
      app
      color="primary"
      dark
    >
      <div class="container d-flex align-center justify-space-between w-full">
        <div class="d-flex align-center justify-start">
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

        <div>
          <v-dialog
            v-model="dialog"
            width="500"
          >
            <template v-slot:activator="{ on, attrs }">
              <v-btn
                class="ma-2 d-block"
                outlined
                v-bind="attrs"
                v-on="on"
                >
                <v-icon>mdi-account-plus</v-icon>
              </v-btn>
            </template>

            <v-card>
              <v-card-title class="text-h5 grey lighten-2">
                New User
              </v-card-title>

              <v-card-text>
                <v-text-field v-model="add_user_name" label="User Name"></v-text-field>
              </v-card-text>

              <v-divider></v-divider>

              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn
                  color="primary"
                  text
                  @click="createUser()"
                >
                  ADD
                </v-btn>
              </v-card-actions>
            </v-card>
          </v-dialog>
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
import {postUser} from '@/repositories/user'

export default Vue.extend({
  name: 'App',

  data: () => ({
    //
    dialog: false,
    add_user_name: ""
  }),
  methods: {
    createUser() {
      postUser(this.add_user_name)
        .then(res => {
          this.dialog = false;
          this.add_user_name = "";
        })
    }
  }
});
</script>

<style scoped>
.container {
  width: auto;
  max-width: 1000px;
  margin: 0 auto;
}

.w-full {
  width: 100%;
}

</style>