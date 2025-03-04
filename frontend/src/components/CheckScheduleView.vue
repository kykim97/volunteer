<template>

    <v-data-table
        :headers="headers"
        :items="checkSchedule"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'CheckScheduleView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            checkSchedule : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/checkSchedules'))

            temp.data._embedded.checkSchedules.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.checkSchedule = temp.data._embedded.checkSchedules;
        },
        methods: {
        }
    }
</script>

