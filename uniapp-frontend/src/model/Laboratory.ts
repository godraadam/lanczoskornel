import { Assignment } from "./Assignment";
import { Attendance } from "./Attendance";
import { BaseModel } from "./BaseModel";
import { Curriculum } from "./Curriculum";

export interface Laboratory extends BaseModel {
    title : String
    number : Number
    description : String
    date : Date
    curriculum : Curriculum
    assignments : Assignment[]
    attendances : Attendance[]
}