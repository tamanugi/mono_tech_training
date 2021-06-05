<template>
<div class="wrapper">
  <v-row>
    <v-col cols="12">
      <h2>Awesome User Search System</h2>
    </v-col>
  </v-row>

  <v-row>
    <v-col cols=12 class="d-flex justify-center">
      <v-text-field
        class="w-60"
        v-model="userName"
        :append-outer-icon="userName ? 'mdi-account-search' : ''"
        @click:append-outer="onClickSearch"
        clear-icon="mdi-close-circle"
        clearable
        label="User Name"
        type="text"
      >
      </v-text-field>
    </v-col>
  </v-row>

  <v-row v-if="users">
    <v-col col=12 class="d-flex justify-center">
      <div class="w-60">
        <v-simple-table v-if="users.length > 0">
          <template v-slot:default>
            <thead>
              <tr>
                <th class="text-left">ID</th>
                <th class="text-left">NAME</th>
              </tr>
            </thead>
            <tbody>
              <tr
                v-for="user in users"
                :key="user.id"
              >
                <td class="text-left">
                  <a :href="`/${user.id}`">{{user.id}}</a>
                </td>
                <td class="text-left">{{ user.name }}</td>
              </tr>
            </tbody>
          </template>
        </v-simple-table>
        <div v-else>
          user not found😿
        </div>
      </div>
    </v-col>
  </v-row>
</div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import { User } from '@/types/'
import { findByName } from '@/repositories/user'

@Component({
  components: {
  },
})
export default class Home extends Vue {
  userName = ''

  users:User[] | null = null

  onClickSearch() {
    findByName(this.userName).then(users => {
      this.users = users
    })
  }
}
</script>

<style scoped>
.wrapper {
  margin-left: 32px;
  text-align: center;
}

h2 {
  font-size: 48px;
}

.w-60 {
  min-width: 60%;
  max-width: 60%;
}
</style>
