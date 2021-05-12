<template>
  <div>
    <div>
      <h3>検索条件</h3>
      <div>
        <label>User Name</label>
        <input type="text" v-model="userName">
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
          <tr>
            <td><a href="detail.html">001</a></td>
            <td>Tanaka</td>
          </tr>
          <tr>
            <td><a href="detail.html">002</a></td>
            <td>Tamura</td>
          </tr>
          <tr>
            <td><a href="detail.html">003</a></td>
            <td>Nakamura</td>
          </tr>
        </tbody>
      </table>

    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
  name: 'UserSearch',
  components: {
  },
});
</script>
