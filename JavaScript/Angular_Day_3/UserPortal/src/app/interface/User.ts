import {Role} from "./Role";

export interface User {
  id: number;
  role: Role;
  givenName: string;
  familyName: string;
  username: string;
  email: string;
  password: string;
  phone: string;
}
