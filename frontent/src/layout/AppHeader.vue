<script>
export default {
  name: "AppHeader",
  computed:{
    authenticated() {
      return this.$store.getters.authenticated();
    },
    data(){
      return {
        firstName:this.$store.getters.account.firstName
      }
    },
  },methods:{
    login(){
      this.$router.push("/AppLogin")
    },
    logout(){
      localStorage.removeItem("market-token")
      sessionStorage.removeItem("market-token")
      this.$store.commit("logout")
      this.$router.replace("/login")
    }
  }
}
</script>

<template>
  <div>

    <el-dropdown>
      <i class="el-icon-setting" style="margin-right: 15px"></i>
      <el-dropdown-menu slot="dropdown">
        <el-dropdown-item>View</el-dropdown-item>
        <el-dropdown-item v-if="!authenticated" ><span @click="login">Kirish</span></el-dropdown-item>
        <el-dropdown-item v-else-if="authenticated" ><span @click="logout">Chiqish</span></el-dropdown-item>
      </el-dropdown-menu>
    </el-dropdown>
    <span>{{firstName}}</span>

  </div>
</template>

<style scoped>



</style>