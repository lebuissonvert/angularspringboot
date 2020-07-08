import { User } from '../model/user';

export class PaginatedUser {
  totalRecords: number;
  users: User[];
}
