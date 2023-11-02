package br.com.fiap.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import br.com.fiap.entity.Taskes;
import br.com.fiap.repository.TaskRepository;

@Service
public class TaskService {
	private final TaskRepository taskesRepository;

	public TaskService(TaskRepository taskesRepository) {
		this.taskesRepository = taskesRepository;
	}

	public List<Taskes> getAllTaskes() {
		return taskesRepository.findAll();
	}

	public Optional<Taskes> getTaskesById(Long id) {
		return taskesRepository.findById(id);
	}

	public Taskes createTaskes(Taskes taskes) {
		return taskesRepository.save(taskes);
	}

	public void deleteTaskes(Long id) {
		taskesRepository.deleteById(id);
	}

	public Taskes updateTaskes(Long id, Taskes updatedTaskes) {
		Optional<Taskes> existingTaskesOptional = taskesRepository.findById(id);

		if (existingTaskesOptional.isPresent()) {
			Taskes existingTaskes = existingTaskesOptional.get();
			existingTaskes.setTitle(updatedTaskes.getTitle());
			existingTaskes.setDescription(updatedTaskes.getDescription());
			existingTaskes.setStatus(updatedTaskes.getStatus());
			existingTaskes.setDueDate(updatedTaskes.getDueDate());

			return taskesRepository.save(existingTaskes);
		} else {
			throw new EntityNotFoundException("Taskes not found with id: " + id);
		}
	}
}
