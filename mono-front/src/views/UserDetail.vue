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
import { defineComponent, onMounted, reactive } from 'vue';
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
  setup() {
    const route = useRoute()
    const { id } = route.params

    const state = reactive<State>({})

    onMounted(() => {
      axios.get<User[]>("http://localhost:3000/users")
        .then(res => {
          state.user = res.data.find(user => user.id === id);
        })
    })

    return {
        state
    }
  },
})
</script>