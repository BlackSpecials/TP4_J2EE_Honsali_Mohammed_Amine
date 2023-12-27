package ma.Honsali_Mohammed_Amine.TP4;

import ma.Honsali_Mohammed_Amine.TP4.model.Etudiant;
import ma.Honsali_Mohammed_Amine.TP4.repository.EtudiantRepository;
import ma.Honsali_Mohammed_Amine.TP4.service.EtudiantService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EtudiantServiceTest {

    @Mock
    private EtudiantRepository etudiantRepository;

    @InjectMocks
    private EtudiantService etudiantService;

    @Test
    public void testGetAllEtudiants() {
        // Arrange
        Etudiant etudiant1 = new Etudiant(1L, "Nom1", "CIN1", "Niveau1");
        Etudiant etudiant2 = new Etudiant(2L, "Nom2", "CIN2", "Niveau2");
        List<Etudiant> etudiants = Arrays.asList(etudiant1, etudiant2);

        when(etudiantRepository.findAll()).thenReturn(etudiants);

        // Act
        List<Etudiant> result = etudiantService.getAllEtudiants();

        // Assert
        assertEquals(etudiants, result);
    }

    @Test
    public void testGetEtudiantById() {
        // Arrange
        Etudiant etudiant = new Etudiant(1L, "Nom1", "CIN1", "Niveau1");

        when(etudiantRepository.findById(1L)).thenReturn(Optional.of(etudiant));

        // Act
        Optional<Etudiant> result = etudiantService.getEtudiantById(1L);

        // Assert
        assertEquals(Optional.of(etudiant), result);
    }

    @Test
    public void testAddEtudiant() {
        // Arrange
        Etudiant etudiant = new Etudiant(1L, "Nom1", "CIN1", "Niveau1");

        // Act
        etudiantService.addEtudiant(etudiant);

        // Assert
        verify(etudiantRepository, times(1)).save(etudiant);
    }

    @Test
    public void testUpdateEtudiant() {
        // Arrange
        Etudiant etudiant = new Etudiant(1L, "Nom1", "CIN1", "Niveau1");

        // Act
        etudiantService.updateEtudiant(etudiant);

        // Assert
        verify(etudiantRepository, times(1)).save(etudiant);
    }

    @Test
    public void testDeleteEtudiant() {
        // Arrange
        Long etudiantId = 1L;

        // Act
        etudiantService.deleteEtudiant(etudiantId);

        // Assert
        verify(etudiantRepository, times(1)).deleteById(etudiantId);
    }
}
