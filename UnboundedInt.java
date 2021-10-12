/**
 * @author
 *  Josh Malaguti
 *  (Julia Boyuk)
 * @version 
 *  10 11 2021 - 
 * 
 * UnboundedInt Class
 *  This class creates the ability for a user to store a numerical integer value of any size.
 *  - It will only store positive numbers
 * 
 * <Assignment>
 *   Project 2
 * <Course>
 *   CSC 103
 */


class UnboundedInt implements Cloneable {

   // Define instance variables:
   private int manyItems;  // represents the number of nodes 
   private IntNode head;   // represents the last 3 integers in the number String
   private IntNode tail;   // represents the first 3 integers in the number String
   private IntNode cursor; 
   

   // UnboundedInt Constructor:
   public UnboundedInt (String numbers) { 
       
      // initialize manyItems to 0 and cursor to null:
      manyItems = 0; 
      cursor = null;
       

      // if the String 'numbers' is an empty 
      if ( numbers != "" || numbers != " " ) { 

         int i;
         String subNum; // Represents smaller sections of 'numbers' String
            
         /** Main idea:
         * The String is broken into three characters (from the back of the string to the front).
         * The varibles are then placed into nodes and parsed to an integer data type starting 
         * from the the head node until the the first characters in the string are stored at the tail node.
         */

            // Loop through numbers starting from the back and add place every 3 characters 
         for (i = numbers.length(); i > 0; i-=3) { 
            
               // If there is 2 or less characters left in the subNum
            if (i>2) {
               subNum = numbers.substring (i-3, i); 
            }
            else {
               subNum = numbers.substring (0, i); 
            }

               
               // If head node is null, the first substring is strod here
            if (head == null) { 
               head = new IntNode (Integer.parseInt (subNum), null);
               cursor = head;
               }
                  
                  // Otherwise, if tail is null, tail stores the next substring, 
                  // and when tail is not null, every substring will become the new 
                  // tail node. 
                  
                  else { 
                  
                        if (head != null && tail == null) { 
                        tail = new IntNode (Integer.parseInt (subNum), null);
                        } 
                        
                        else { 
                           cursor.addNodeAfter(tail.getData());
                           tail = new IntNode (Integer.parseInt(subNum), null);
                           advance();
                           }
                        }   
            // Increment manyItems                 
            manyItems++;
            } 
         }  


      else {
         throw new IllegalArgumentException ("This is not a valid number!");
      }
         
      // else { 
         
      //    int i;
      //    String subNum;
         
      //    // The String is broken into three characters (from the back of the string to the front)
      //    // The varibles are then placed into nodes and parsed to an integer data type starting 
      //    // from the the head node until the the first characters in the string are stored at the tail node.
         
      //    for (i = numbers.length (); i > 0; i-=3) { 
            
      //       // If the there are only 1-2 characters at the front of the String, they are stored with that many characters 
            
      //       if (i == 2 || i == 1) { 
      //       subNum = numbers.substring (0, i); 
      //       }
            
      //       // Otherwise, three characters will be stored 
            
      //       else { 
      //          subNum = numbers.substring (i-3, i); 
      //          }
            
      //       // If head node is null, the first substring is strod here
            
      //       if (head == null) { 
      //          head = new IntNode (Integer.parseInt (subNum), null);
      //          cursor = head;
      //          }
                  
      //             // Otherwise, if tail is null, tail stores the next substring, 
      //             // and when tail is not null, every substring will become the new 
      //             // tail node. 
                  
      //             else { 
                  
      //                   if (head != null && tail == null) { 
      //                   tail = new IntNode (Integer.parseInt (subNum), null);
      //                   } 
                        
      //                   else { 
      //                      cursor.addNodeAfter(tail.getData());
      //                      tail = new IntNode (Integer.parseInt(subNum), null);
      //                      advance();
      //                      }
      //                   }   
                                 
      //       manyItems++;
      //       } 
      //    }   
         } // end of constructor
           
        
      
   /**
    * This method adds the current UnboundedInt with a passed in one
    * @param num
    *  UnboundedInt object
    * @return newInt
    *  The new UnboundedInt
   */
   public static UnboundedInt add (UnboundedInt numbers) { 
      return null;
   } // end of add()



   /**
    * This method multiplies the current UnboundedInt with a passed in one
    * @param num
    *  And UnboundedInt obj
    * @return          
    *  New Unbounded Int
   */
   public static UnboundedInt multiply (UnboundedInt numbers) { 
      return null;
   }  // end of multiply()
      


   /**
    * This method adds a new element at the end of the sequence to use for building up each higher term in a single sequence
    * Add new IntNode to linkedList
    * @param nums
    *  Any intger value
    * @return none
   */
   public void addEnd (int numbers) { 

         // if manyItems is greater than one, set the tail link to the number, with null ref. 
      if (manyItems > 1) { 
      
         tail.setLink(new IntNode(numbers,null));
         tail = tail.getLink();
         }
         
         // Otherwise set tail to new node of the number with null ref
      else { 
         tail = new IntNode (numbers, null);
         }    
      
         // 
      manyItems++;
      }
         
        
      
   /**
    * This method will return a copy of the original inputed structure
    * @precondition
    *  
    * @return
    *  Returns copy of original structure
   */
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
   }  // end of clone()
      


   /**
    * This method returns true if linked list represents same numerical number as input paramter. Is false otherwise
    *@return boolean
    *    true - if linked list reprsents same numerical number as the input parameter
    *    false - if linked list doesnt represent same numerical nujmber as the input parameter
    */
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
   }// end of equals()
         


   /**
    * This method creates a string of all elements in order separated by commas, making usre leading zeros are added when needed
    * @throws IlegallStateException 
    *  If sequence is empty
    * @return 
    *  Return the created string
   */
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
   } // end of toString()
            
            

   /**
    * This method sets the cursor to the front of the list
    *@param none
    */
   public void start ()
   {
      // set the cursor to head:
      cursor = head;
   }
         

  
   /**
    * This method moves the cursor along the list
    *@throws IllegalStateException
    *  if the cursor is null
   */
   public void advance () { 
      
      if (cursor == null) { 
         throw new IllegalStateException ("The cursor value is null");
         }
         
         else { 
            cursor = cursor.getLink ();
            }
   }
   

      
   /**
    * This method returns the integer value of the Node that is pointed to by the cursor
    * @throws IllagalStateException 
    *    if the cursor is not point to a Node
    * @return cursor.getData()
    *    The data stored in the node the cursor is currently on
    */
   public int getNodeValue () { 
      
      if (cursor == null) { 
         throw new IllegalStateException ("The cursor does not have an assigned node value");
         }
         
         else  { 
            return cursor.getData ();
            }    
   } // end of getNodeValue()
      

         
   /**
    * This method creates a string of all elements in order, making sure leading zeros are added when needed
    * @throw IllegalStateException
    *    if sequence is empty
    * @return number
    *    The 
    */
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