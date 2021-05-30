<template>
<div>
  <h3>検索条件</h3>
  <div>
    <label>User Name</label><input type="text" v-model="userName">
    <button @click="onClickSearch">Search</button>
  </div>
  <h3>検索結果</h3>
  <table border="1">
    <thead>
      <tr>
        <th>User Id</th>
        <th>User Namme</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="user in users" :key="user.id">
        <td><a :href='`/${user.id}`'>{{user.id}}</a></td>
        <td>{{user.name}}</td>
      </tr>
    </tbody>
  </table>
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

  users:User[] = []

  onClickSearch() {
    findByName(this.userName).then(users => {
      this.users = users
    })
  }
}
</script>
