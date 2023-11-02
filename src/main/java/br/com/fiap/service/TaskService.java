package br.com.fiap.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import br.com.fiap.entity.Tasks;
import br.com.fiap.repository.TaskRepository;

@Service
public class TaskService {
	private final TaskRepository taskesRepository;

	public TaskService(TaskRepository taskesRepository) {
		this.taskesRepository = taskesRepository;
	}

	public List<Tasks> getAllTaskes() {
		return taskesRepository.findAll();
	}

	public Optional<Tasks> getTaskesById(Long id) {
		return taskesRepository.findById(id);
	}

	public Tasks createTaskes(Tasks taskes) {
		return taskesRepository.save(taskes);
	}

	public void deleteTaskes(Long id) {
		taskesRepository.deleteById(id);
	}

	public Tasks updateTaskes(Long id, Tasks updatedTaskes) {
		Optional<Tasks> existingTaskesOptional = taskesRepository.findById(id);

		if (existingTaskesOptional.isPresent()) {
			Tasks existingTaskes = existingTaskesOptional.get();
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
