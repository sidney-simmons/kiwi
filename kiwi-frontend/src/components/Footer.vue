<template>
    <footer class="text-muted">
        <div>
            <div>Application version: {{ implementationVersion }}</div>
            <div>Node: {{ hostName }}</div>
            <div>Up time: {{ formatUpTime(upTime) }}</div>
        </div>
    </footer>
</template>

<script>
import EnvironmentService from "@/services/EnvironmentService";
import moment from "moment/dist/moment";

export default {
    name: "Footer",
    data: function () {
        return {
            implementationVersion: "...",
            hostName: "...",
            upTime: "...",
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
                    this.upTime = response.data.upTime;
                })
                .catch((error) => {
                    console.error(error);
                    this.implementationVersion = "Unknown";
                    this.hostName = "Unknown";
                    this.upTime = "Unknown";
                });
        },
        formatUpTime: function (upTimeString) {
            if (upTimeString === "...") {
                // The environment data hasn't been pulled from the API yet
                return "...";
            } else {
                let upTimeDate = moment(upTimeString);
                if (upTimeDate.isValid()) {
                    return upTimeDate.fromNow(true);
                } else {
                    return "Unknown";
                }
            }
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
