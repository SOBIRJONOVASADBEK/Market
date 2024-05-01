<script>
import AccountService from "@/account/account.service";
export default {
  name: "AppAside",
  data(){
    return{
      hasAnyAuthorityValue:false
    }
  },
  computed:{
    authenticated() {
      return this.$store.getters.authenticated();
    }
    },
  methods:{
    hasAnyAuth(){
      new AccountService(this.$router,this.$store)
          .hasAnyAuthorityAndAuth()
          .then(value => {
            this.hasAnyAuthorityValue=value;
          });
      return this.hasAnyAuthorityValue;
    }

    }
}
</script>

<template>
  <div>


    <el-aside width="200px" style="background-color: rgb(238,241,246)" v-if="hasAnyAuth('ROLE_ADMIN') && authenticated">
      <el-menu :default-openeds="['1','3']">
        <el-submenu index="1">
          <template slot="title"><i class="el-icon-message"></i>Malumotlar</template>
          <el-menu-item-group>
            <el-menu-item index="1-1">Mahsulotlar</el-menu-item>
            <el-menu-item index="1-2"></el-menu-item>
          </el-menu-item-group>
          <el-menu-item-group>
            <template slot="title">Group 2</template>
            <el-menu-item index="1-3">Option 3</el-menu-item>
          </el-menu-item-group>
          <el-submenu index="1-4">
            <template slot="title">Option 4</template>
            <el-menu-item index="1-4-1">Option 4-1</el-menu-item>
          </el-submenu>
        </el-submenu>
        <el-submenu index="2">
          <template slot="title"><i class="el-icon-menu"></i>Navigator two </template>
          <el-menu-item-group>
            <template slot="title">Group 1</template>
            <el-menu-item index="2-1">Option 1</el-menu-item>
            <el-menu-item index="2-2">Option 2</el-menu-item>
          </el-menu-item-group>
          <el-menu-item-group>
            <template slot="title">Group 2</template>
            <el-menu-item index="2-3">Option 3</el-menu-item>
          </el-menu-item-group>
          <el-submenu index="2-4">
            <template slot="title">Option 4</template>
            <el-menu-item index="2-4-1">Option 4-1</el-menu-item>
          </el-submenu>
        </el-submenu>
      </el-menu>
    </el-aside>

  </div>
</template>

<style scoped>

</style>