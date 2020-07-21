<template>
    <footer class="text-muted">
        <div>
            <div>Application version: {{ implementationVersion }}</div>
            <div>Node: {{ hostName }}</div>
        </div>
    </footer>
</template>

<script>
import EnvironmentService from "@/services/EnvironmentService";

export default {
    name: "Footer",
    data: function () {
        return {
            implementationVersion: "...",
            hostName: "...",
        };
    },
    mounted: function () {
        this.setEnvironment();
    },
    methods: {
        setEnvironment: function () {
            EnvironmentService.getEnvironment()
                .then((response) => {
                    this.implementationVersion = response.data.implementationVersion;
                    this.hostName = response.data.hostName;
                })
                .catch((error) => {
                    console.error(error);
                    this.implementationVersion = "Unknown";
                    this.hostName = "Unknown";
                });
        },
    },
};
</script>

<style scoped>
footer {
    text-align: center;
    font-family: monospace;
    padding-left: 10px;
    padding-right: 10px;
    margin-bottom: 15px;
}
</style>
