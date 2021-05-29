<template>
<div>
    <dl v-if="state.user">
        <dt>User ID</dt>
        <dd>{{state.user.id}}</dd>
        <dt>User Name</dt>
        <dd>{{state.user.name}}</dd>
    </dl>
    <div v-if="!state.user">loading...</div>
</div>
</template>

<script lang="ts">
import axios from 'axios';
import { defineComponent, reactive } from 'vue';
import { useRoute } from 'vue-router'

interface User {
  id: string;
  name: string;
}
interface State {
  user?: User;
}

export default defineComponent({
  name: 'UserSearch',
  async setup() {
    const route = useRoute()
    const { id } = route.params
    const user =
      await axios.get<User[]>("http://localhost:3000/users")
        .then(res => {
          return res.data.find(u => u.id === id);
        })

    const state = reactive<State>({user})

    return {
        state
    }
  },
})
</script>