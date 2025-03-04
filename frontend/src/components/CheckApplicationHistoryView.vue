<template>

    <v-data-table
        :headers="headers"
        :items="checkApplicationHistory"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'CheckApplicationHistoryView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            checkApplicationHistory : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/checkApplicationHistories'))

            temp.data._embedded.checkApplicationHistories.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.checkApplicationHistory = temp.data._embedded.checkApplicationHistories;
        },
        methods: {
        }
    }
</script>

