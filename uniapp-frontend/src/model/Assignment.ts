import { BaseModel } from "./BaseModel";
import { Laboratory } from "./Laboratory";

export interface Assignment extends BaseModel {
    deadline : Date
    description : String
    laboratory : Laboratory
}