/*
infrateam and application team
 */
import { OrderProduct } from './orderproduct.interface';

export interface Order {
  id: string;
  name: string;
  orderProduct: OrderProduct[];
}
