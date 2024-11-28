// 专门用于存储日程状态信息
import { defineStore} from "pinia"

export const defindSchedule = defineStore(
    "scheduleList",
    {
        state: () => {
            return {
                itemList: []
            }
        },

        getters: {

        },
        actions: {

        },



    }
)