class UnboundedInt implements Cloneable {

   private int manyItems;
   private IntNode head;
   private IntNode tail;
   private IntNode cursor;
   
   public UnboundedInt (String numbers) { 
       
       manyItems = 0;
       cursor = null;
       
       if ( numbers == "" ) { 
         throw new IllegalArgumentException ("This is not a valid number!");
         }
         
         else { 
            
            int i;
            String smallNum;
            
            // The String is broken into three characters (from the back of the string to the front)
            // The varibles are then placed into nodes and parsed to an integer data type starting 
            // from the the head node until the the first characters in the string are stored at the tail node.
            
            for (i = numbers.length (); i > 0; i-=3) { 
               
               // If the there are only 1-2 characters at the front of the String, they are stored with that many characters 
               
               if (i == 2 || i == 1) { 
               smallNum = numbers.substring (0, i); 
               }
               
               // Otherwise, three characters will be stored 
               
               else { 
                  smallNum = numbers.substring (i-3, i); 
                  }
               
               // If head node is null, the first substring is strod here
               
               if (head == null) { 
                  head = new IntNode (Integer.parseInt (smallNum), null);
                  cursor = head;
                  }
                    
                     // Otherwise, if tail is null, tail stores the next substring, 
                     // and when tail is not null, every substring will become the new 
                     // tail node. 
                     
                     else { 
                     
                         if (head != null && tail == null) { 
                           tail = new IntNode (Integer.parseInt (smallNum), null);
                           } 
                           
                           else { 
                              cursor.addNodeAfter(tail.getData());
                              tail = new IntNode (Integer.parseInt(smallNum), null);
                              advance();
                              }
                          }   
                                   
               manyItems++;
               } 
               } 
               
         } 
           
      
       
      
      
//       public static UnboundedInt add (UnboundedInt numbers) { 
//          
//          }
//        
//        
//       public static UnboundedInt multiply (UnboundedInt numbers) { 
//          
//          }   
//          
      public void addEnd (int numbers) { 
      System.out.println ("Tail: " + tail.getData());
         IntNode end = new IntNode (numbers, tail);
         tail = end;
         System.out.println ("Tail: " + tail.getData());
         manyItems++;
         }
         
         
      public UnboundedInt clone () { 
      
         UnboundedInt newClone;
         
         try { 
         newClone = (UnboundedInt) super.clone();
         }
         
         catch (CloneNotSupportedException e) { 
            throw new RuntimeException ("This class has no implemented clonable");
            }            

       if (manyItems == 1) { 
          newClone.head = head;
          return newClone;
          }
          
          else if (manyItems > 1) { 
            newClone.head = head;
            newClone.tail = tail;
            return newClone;
            }
       
      return newClone;
      }



      @Override       
      public boolean equals (Object obj) { 
      
         boolean equal = true;
         
         if (obj instanceof UnboundedInt) { 
            UnboundedInt a1 = (UnboundedInt) obj;
            
             // If the sequence has only a head node and they are equal, return true
             
             if (manyItems == 1 && a1.manyItems == 1 && head.getData () == a1.head.getData ()) { 
               equal = true;
               }
               
               // Otherwise, return false
                   
               else if (manyItems == 1 && a1.manyItems == 1 && head.getData () != a1.head.getData ()) { 
                  equal = false;
                  }
                  
                  // If there are not the same number of nodes, return false
                  
                  else if (manyItems != a1.manyItems) {
                     equal = false;
                     } 
                                    
             // If the head node's data doesnt match eachother, return false
             
             if (head.getData ( ) != a1.head.getData ()) { 
                 equal = false;
                 }         
            
            start();
            a1.start();       
            
            // While the cursor is equal to the other object cursor, and the amount of items is both equal to             
            // eachother and greater than 1, repeat the sequence.
            
            while (cursor.getData() == a1.cursor.getData () && manyItems > 1 && manyItems == a1.manyItems) { 
            
                // If the both cursor's data are equal, continue the sequence. 
                 
                 if (cursor != null && a1.cursor != null ) { 
                     advance ();
                     a1.advance ();
                     equal = true;
                     }
               
                     // If either becomes null, break from the sequence witha an equal value of false.
                     
                     if ((cursor == null && a1.cursor != null) || (cursor != null  && a1.cursor == null)) { 
                        equal = false;
                        break;
                        }
              
                        // If either the tail or head of the sequence is not equal to the other objects data, break from the sequence
                        // with an equal value of false.
                        
                        if (tail.getData () != a1.tail.getData () || head.getData () != a1.head.getData ()) { 
                           equal = false;
                           break;
                           }
                           
                           // If the end of the sequence is reached and the tail values of both objects are the same, break from the sequence
                           // with an equal value of true
                           
                           if (cursor == null && a1.cursor == null && tail.getData () == a1.tail.getData ()) { 
                               equal = true;
                               break;
                               }  
                                                          
                       }  
             }
             
             // If the object is not an instance of UnboundedInt, return false
             
             else { 
               equal = false;
               } 
                    
      return equal;    
      }
         
         
      public String toString () { 

         if (manyItems == 0) { 
            throw new IllegalStateException ("There are no elements in this sequence"); 
            }  
            
           String number = "";
           start();
         
           if (cursor == head) { 
               
               if (head.getData () < 100 && head.getData () >= 10 ) {
                  number = "0" + Integer.toString (head.getData());
                  }
                  
                  else if (head.getData () < 10 ) { 
                      number = "00" + Integer.toString (head.getData());
                      }
                      
                      else { 
                        number = Integer.toString (head.getData());
                        }
               
               advance ();         
               }     
                          
            while (cursor != null && manyItems > 1) { 
               
               if (cursor.getData () < 100 && cursor.getData () >= 10 ) {
                  number = "0" + Integer.toString (cursor.getData()) + "," + number;
                  }
                  
                  else if (cursor.getData () < 10 ) { 
                      number = "00" + Integer.toString (cursor.getData()) + "," + number;
                      }
                           
                     else if (cursor.getData () > 100 ) { 
                            number = Integer.toString (cursor.getData()) + "," + number;
                            }
                            
               advance ();
               }
          
          if (manyItems > 1 && tail.getData () != 0) { 
               number = Integer.toString (tail.getData()) + "," + number;
               }
               
               else if (manyItems == 1 && head.getData () < 999) {
                  number = Integer.toString (head.getData());
                  }
                                
          return number;
          }
            
            
         
      public void start () { 
      
         cursor = head;
         }
         
         
      public void advance () { 
         
         if (cursor == null) { 
            throw new IllegalStateException ("The cursor value is null");
            }
            
            else { 
               cursor = cursor.getLink ();
               }
      }
      
      
      public int getNodeValue () { 
         
         if (cursor == null) { 
            throw new IllegalStateException ("The cursor does not have an assigned node value");
            }
            
            else  { 
               return cursor.getData ();
               }
            
           
      }
      
         
      public String toStringNoCommas () { 
      
         if (manyItems == 0) { 
            throw new IllegalStateException ("There are no elements in this sequence"); 
            }  
            
           String number = "";
           start();
         
           if (cursor == head) { 
               
               if (head.getData () < 100 && head.getData () >= 10 ) {
                  number = "0" + Integer.toString (head.getData());
                  }
                  
                  else if (head.getData () < 10 ) { 
                      number = "00" + Integer.toString (head.getData());
                      }
                      
                      else { 
                        number = Integer.toString (head.getData());
                        }
               
               advance ();         
               }
                      
                          
            while (cursor != null && manyItems > 1) { 
               
               if (cursor.getData () < 100 && cursor.getData () >= 10 ) {
                  number = "0" + Integer.toString (cursor.getData()) + number;
                  }
                  
                  else if (cursor.getData () < 10 ) { 
                      number = "00" + Integer.toString (cursor.getData()) + number;
                      }
                           
                     else if (cursor.getData () > 100 ) { 
                            number = Integer.toString (cursor.getData()) + number;
                            }
                            
               advance ();
               }
          
          if (manyItems > 1 && tail.getData () != 0) { 
               number = Integer.toString (tail.getData()) + number;
               }
               
               else if (manyItems == 1 && head.getData () < 999) {
                  number = Integer.toString (head.getData());
                  }
                                
          return number;
          }
           
} // End Class