<template>
  <article class="login-form">
    <form action="" @submit.prevent class="form">
      <div class="login-fields">
        <label for="email">Email</label>
        <input type="text" name="email" id="email" v-model="user.email" />
      </div>
      <div class="login-fields">
        <label for="password">Password</label>
        <input
          type="password"
          name="password"
          id="password"
          v-model="user.password"
        />
      </div>
      <input
        type="button"
        value="Login"
        :disabled="submitEnabled"
        class="login-button"
        :class="[submitEnabled ? 'disabled' : 'enabled']"
        @click="login"
      />
    </form>
  </article>
</template>

<script>
import { useLogin } from "@/uses/useLogin";
import { computed, defineComponent } from "vue";
export default defineComponent({
  name: "Login",
  setup() {
    const { user, login } = useLogin();
    const submitEnabled = computed(() => {
      let emailValidate = user.value.email !== null && user.value.email !== "";
      let passwordValidate = user.value.password !== null && user.value.password !== "";
      return !(emailValidate && passwordValidate);
    });
    return { user, login, submitEnabled };
  },
});
</script>

<style scoped>

  .form{
    display: inline;

  }

  .login-form{
    margin: 5%;
  }

  input{
    flex-basis: 0;
    flex-grow: 1;
    height: 2rem;
    width: 30rem;
    background: #f2f2f2;
    border: 1px solid #cccccc;
    border-radius: 2rem;
    outline: none;
    font-size: 1.2rem;
    color: #737373;
    letter-spacing: 1px;
    text-indent: 2rem;
  }

  .login-fields{
    padding: 10px;
  }

  label{
    padding: 5px;
    flex-basis: 0;
    flex-grow: 1;
    padding: 0.3rem 0.5rem;
    height: 2rem;
    width: 30rem;
    outline: none;
    font-size: 1.2rem;
    color: #737373;
    letter-spacing: 1px;
    text-indent: 2rem;
  }

  .login-button{
    border: 2px solid;
  }

  .enabled:hover{
    background: #87a8e6;
    color: black;
  }

</style>