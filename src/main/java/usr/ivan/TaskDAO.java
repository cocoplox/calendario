package usr.ivan;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import usr.ivan.models.HibernateUtil;
import usr.ivan.models.Task;

public class TaskDAO {
    public void saveTask(Task task) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(task); 
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Deshacer la transaccion en caso de error
            }
            e.printStackTrace();
        }
    }

    public void updateTask(Task updatedTask) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(updatedTask);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();

            }
            e.printStackTrace();
        }
    }

    public Task getTaskById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Task.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Task> getAllTasks() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Task> query = session.createQuery("FROM Task", Task.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteTaskById(long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Task tareaAEliminar = session.get(Task.class, id);
            if (tareaAEliminar != null) {
                session.remove(tareaAEliminar);
                System.out.println("Tarea eliminada correctamente");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }
}
