<template>

    <v-data-table
        :headers="headers"
        :items="volunteerhistory"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'VolunteerhistoryView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "userId", value: "userId" },
                { text: "associationId", value: "associationId" },
                { text: "title", value: "title" },
                { text: "category", value: "category" },
                { text: "schedule", value: "schedule" },
            ],
            volunteerhistory : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/volunteerhistories'))

            temp.data._embedded.volunteerhistories.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.volunteerhistory = temp.data._embedded.volunteerhistories;
        },
        methods: {
        }
    }
</script>

