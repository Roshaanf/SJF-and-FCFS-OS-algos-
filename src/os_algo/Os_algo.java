/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os_algo;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Roshaann 2.7 gpa
 */
public class Os_algo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Random r=new Random();
        
      
        LinkedList l=new LinkedList();
      //no of process
        int j=5;
        Process[] p=new Process[j];
      
        for(int h=0;h<j;h++){
         //initializing processes   
        p[h]= new Process(h,(h+1));
       //filling linked list with processes
        l.add(p[h]);
       
        }
        
        
        algo_cs i=new algo_cs();
      // for SJF
        l=i.SJF(l);
          System.out.println("\t\t\t\t Shortest Job First  Algorithm\n\n");
        
        System.out.println("Process id\tArrival time\tStart time\tExecution time\tTurnaround time\tFinish time\tWait time");  

        for(int k=0;k<j;k++){
        
            p[k]=(Process) l.get(k);
            System.out.println(""+p[k].pid+"\t\t"+p[k].arrival+"\t\t"+p[k].start_time+"\t\t"+p[k].exe_time+"\t\t"+ p[k].turn_around+"\t\t"+p[k].fin_time+"\t\t"+p[k].wait_time);
      
        }
        
        System.out.println("");
        System.out.println("");
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t First Come First Serve Algorithm\n\n");
        
//forfcfs
     l=i.fcfs(l);
         
     
     System.out.println("Process id\tArrival time\tStart time\tExecution time\tTurnaround time\tFinish time\tWait time");  

        for(int k=0;k<j;k++){
        
            p[k]=(Process) l.get(k);
            System.out.println(""+p[k].pid+"\t\t"+p[k].arrival+"\t\t"+p[k].start_time+"\t\t"+p[k].exe_time+"\t\t"+ p[k].turn_around+"\t\t"+p[k].fin_time+"\t\t"+p[k].wait_time);
      
        }
     
        
  }
    
}

class Process{
    int arrival;
    int turn_around;
    int exe_time;
    int start_time;
    int wait_time;
    int fin_time;
    int pid;
    
    Process(){
        
    }
    Process(int a,int i){
       Random r=new Random();
        this.arrival=a;
        this.exe_time=r.nextInt(4)+r.nextInt(5)+1;
        this.pid=i;
    }
    
   Process small_arvl_time(LinkedList l){
        
       // if(l.size()==3){
         
        int[] arr=new int[l.size()];
        Process[] p =new Process[l.size()];
        
        for(int k=0 ;k<l.size();k++){
                  
         p[k]=(Process) l.get(k);
         arr[k]=p[k].arrival;
        }
       
       
       int min=arr[0];          
       int j=0;
        
        for(int i=1;i<l.size();i++){
        if(min>arr[i]){
            min=arr[i];
            j=i;
        }    
        }
         
    return p[j];
      //return (Process) l.get(j);
    } 
   
   
   
   
    Process small_exe_time(LinkedList l){
        
       // if(l.size()==3){
         
        int[] arr=new int[l.size()];
        Process[] p =new Process[l.size()];
        
        for(int k=0 ;k<l.size();k++){
        
         p[k]=(Process) l.get(k);
         arr[k]=p[k].exe_time;
        }
        
       
       int min=arr[0];          
       int j=0;
        
        for(int i=1;i<l.size();i++){
        if(min>arr[i]){
            min=arr[i];
            j=i;
        }    
        }
        
        
    return p[j];
      //return (Process) l.get(j);
    } 
 }
class algo_cs{
    
    algo_cs(){
        
    }
    
    LinkedList SJF(LinkedList l){
        
       LinkedList ran=new LinkedList();
       
       int f;
       
        Process p=new Process();
        p=p.small_arvl_time(l);
        p.start_time=p.arrival;
        p.fin_time=p.start_time+p.exe_time;
        p.turn_around=p.fin_time-p.arrival;
        p.wait_time=p.turn_around-p.exe_time;
        f=p.fin_time;
        ran.add(p);
        l.remove(p);
        l.descendingIterator();
        
        //System.out.println("st"+p.start_time+"arriv"+p.arrival+"exe"+p.exe_time+"turn"+ p.turn_around);
       while(l.size()>0){
           
       p=p.small_exe_time(l);
        
       
       p.start_time=f;
       p.fin_time=p.start_time+p.exe_time;
       p.turn_around=p.fin_time-p.arrival;
       p.wait_time=p.turn_around-p.exe_time;
       
       f=p.fin_time;
       ran.add(p);
       l.remove(p);
       l.descendingIterator();
       
            
        }
          
        return ran; 
    }
    
    LinkedList fcfs(LinkedList l){
       LinkedList ran=new LinkedList();
       
       int f;
       
        Process p=new Process();
        p=p.small_arvl_time(l);
        p.start_time=p.arrival;
        p.fin_time=p.start_time+p.exe_time;
        p.turn_around=p.fin_time-p.arrival;
        p.wait_time=p.turn_around-p.exe_time;
        f=p.fin_time;
        ran.add(p);
        l.remove(p);
        l.descendingIterator();
        
       
       while(l.size()>0){
           
       p=p.small_arvl_time(l);
        
       
       p.start_time=f;
       p.fin_time=p.start_time+p.exe_time;
       p.turn_around=p.fin_time-p.arrival;
       p.wait_time=p.turn_around-p.exe_time;
       
       f=p.fin_time;
       ran.add(p);
       l.remove(p);
       l.descendingIterator();
       
            
        }
          
        return ran; 
        
        
        
    }
    
    
    
    
}