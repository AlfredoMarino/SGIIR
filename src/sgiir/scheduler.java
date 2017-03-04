/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgiir;

import java.util.Date;
import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.JobBuilder.newJob;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import static org.quartz.TriggerBuilder.newTrigger;
import org.quartz.impl.StdSchedulerFactory;

/**
 *
 * @author Alfredo Mariño
 */
public class scheduler {
    //El horario de la tarea
    private Scheduler tareaProgramada;

    //Metodo que crea el horario
    private void crearProgramacio() {

        try {
            //Creando la programacion
            SchedulerFactory factory = new StdSchedulerFactory();
            //Obteniendo la planificacion
            tareaProgramada = factory.getScheduler();
            //Damos inicio al horario
            //horario.start();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
    //Metodo que da la informacion mas detallada sobre el horario, como hora de inicio de la tarea y cada
    //cuanto tiempo se ejecute la tarea
    public void iniciarTarea() throws SchedulerException, InterruptedException {
        if (this.tareaProgramada == null) {
            this.crearProgramacio();
        }
        
        JobDetail job = newJob(supervisor.class).withIdentity("job1", "group1").build();
        // compute a time that is on the next round minute
        Date runTime = evenMinuteDate(new Date());
        
        
        //ejecuta cada 5 segundos
        Trigger trigger = newTrigger()
                .withIdentity("trigger1", "group1")
                .withSchedule(cronSchedule("5 1 * * * ?")).build();
        
        
        
//        Trigger trigger = newTrigger()
//                .withIdentity("trigger1", "group1")
//                .withSchedule(cronSchedule("0 0/59 09-18 ? * MON-FRI")).build();
        
        
        //////////////////////////////////////////
        //INFORMACION SOBRE LOS CRONSCHEDULER
        //http://www.quartz-scheduler.org/documentation/quartz-2.2.x/examples/Example3.html
        //////////////////////////////////////////
        
        // Tell quartz to schedule the job using our trigger
        tareaProgramada.scheduleJob(job, trigger);

        tareaProgramada.start();
        //Thread.sleep(90L * 1000L);
        
        //horario.shutdown(true);
        
        
    }
}
