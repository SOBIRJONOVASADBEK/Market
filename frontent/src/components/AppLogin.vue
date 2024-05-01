<script>
import axios from "axios";
import AccountService from "@/account/account.service";

export default {

  name: "AppLogin",
  data(){
    return{
      loginVM:{
        username:null,
        password:null
    },
      checked:true
    }
  },
  methods:{
    login(){
      axios.post("api/login",this.loginVM)
          .then(res=>{
            const token=res.data.token;
            if (this.checked) {
              localStorage.setItem("market-token", token);
            }else {
              sessionStorage.setItem("market-token", token)
            }
            new AccountService(this.$router,this.$store).retrieveAccount();
            this.router.push("/")
          })
    }
  }
}
</script>

<template>
  <div style="margin-top: 200px">
    <el-row :gutter="12">
      <el-col span="7" offset="8">
    <el-card shadow="always">
    <el-row :gutter="12">
      <el-col :span="15" :offset="5" >
        <div class="grid-content bg-purple">
          <el-input
          size="small"
          v-model="loginVM.username"
          placeholder="Login">
          </el-input>
          <el-input placeholder="parol"  size="small" v-model="loginVM.password" show-password style="margin-top: 15px" ></el-input>
        </div></el-col>
    </el-row>
    <el-row :gutter="20" style="margin-top: 15px">
      <el-col :span="24" >
        <el-col :span="8" :offset="4">
          <el-checkbox v-model="checked" >Eslab Qolish</el-checkbox>
        </el-col>
      <el-col :span="12">
        <el-button type="primary" plain @click="login">Kirish</el-button>
      </el-col>
      </el-col>
    </el-row>
    </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<style scoped>

</style>