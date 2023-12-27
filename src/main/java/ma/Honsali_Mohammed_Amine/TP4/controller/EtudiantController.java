package ma.Honsali_Mohammed_Amine.TP4.controller;

import ma.Honsali_Mohammed_Amine.TP4.model.Etudiant;
import ma.Honsali_Mohammed_Amine.TP4.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/etudiants")
public class EtudiantController {

    private final EtudiantService etudiantService;

    @Autowired
    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    @GetMapping
    public String getAllEtudiants(Model model) {
        model.addAttribute("etudiants", etudiantService.getAllEtudiants());
        return "etudiant/liste";
    }

    @GetMapping("/ajouter")
    public String showAddForm(Model model) {
        model.addAttribute("etudiant", new Etudiant());
        return "etudiant/formulaire";
    }

    @PostMapping("/ajouter")
    public String addEtudiant(@ModelAttribute("etudiant") Etudiant etudiant) {
        etudiantService.addEtudiant(etudiant);
        return "redirect:/etudiants";
    }

    @GetMapping("/modifier/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Etudiant etudiant = etudiantService.getEtudiantById(id)
                .orElseThrow(() -> new IllegalArgumentException("Étudiant non trouvé avec l'id : " + id));
        model.addAttribute("etudiant", etudiant);
        return "etudiant/formulaire";
    }

    @PostMapping("/modifier/{id}")
    public String updateEtudiant(@PathVariable("id") Long id, @ModelAttribute("etudiant") Etudiant etudiant) {
        etudiant.setId(id);
        etudiantService.updateEtudiant(etudiant);
        return "redirect:/etudiants";
    }

    @GetMapping("/supprimer/{id}")
    public String deleteEtudiant(@PathVariable("id") Long id) {
        etudiantService.deleteEtudiant(id);
        return "redirect:/etudiants";
    }
}
