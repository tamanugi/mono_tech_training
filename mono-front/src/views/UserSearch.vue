<template>
  <div>
    <div>
      <h3>検索条件</h3>
      <div>
        <label>User Name</label>
        <input type="text" v-model="state.userName">
        <button @click="onClickSearch()">Search</button>
      </div>
    </div>

    <div>
      <h3>検索結果</h3>
      <table border="1">
        <thead>
          <tr>
            <th>User Id</th>
            <th>User Name</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="user in state.users" :key="user.id">
            <td><a href="detail.html">{{user.id}}</a></td>
            <td>{{user.name}}</td>
          </tr>
        </tbody>
      </table>

    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent, reactive } from 'vue';

interface User {
  id: string;
  name: string;
}
interface State {
  userName: string
  users: User[]
}

export default defineComponent({
  name: 'UserSearch',
  setup(_, context) {

    const state = reactive<State>({
      userName: '',
      users: [
        { id: "001", name: "Tanaka" },
        { id: "002", name: "Tamura" },
        { id: "003", name: "Nakata" }
      ]
    })

    const onClickSearch = () => {
      window.alert(state.userName)
      return
    }

    return {
      state,
      onClickSearch
    }
  },
  components: {
  },
});
</script>
