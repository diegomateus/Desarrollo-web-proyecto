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