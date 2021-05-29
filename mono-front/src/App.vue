<template> 
<Suspense>
  <template #default>
    <router-view/>
  </template>
  <template #fallback>
    loading...
  </template>
</Suspense>
</template>

<style lang="scss">
</style>
