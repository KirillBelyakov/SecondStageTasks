package JavaErrorsAndExeptions.MainTask;

import JavaErrorsAndExeptions.MainTask.entity.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Runner {
    public static void main(String[] args) {

        List<Group> civilEngineeringGroups = new ArrayList<>();
        List<Group> economicGroups = new ArrayList<>();
        List<Group> mechanicalGroups = new ArrayList<>();
        Group architecture = new Group(Arrays.asList(
                new Student("Петров", "Андрей", Arrays.asList(new Lesson("English", 4), new Lesson("Philosophy", 5), new Lesson("History", 6))),
                new Student("Сидоров", "Александр", Arrays.asList(new Lesson("English", 4), new Lesson("Philosophy", 5), new Lesson("History", 6)))
        ), "architecture");
        Group reconstruction = new Group(Arrays.asList(
                new Student("Волков", "Василий", Arrays.asList(new Lesson("English", 5), new Lesson("Philosophy", 6), new Lesson("History", 7))),
                new Student("Зайцев", "Максим", Arrays.asList(new Lesson("English", 8), new Lesson("Philosophy", 9), new Lesson("History", 10)))
        ), "reconstruction");
        Group technologyAndOrganization = new Group(Arrays.asList(
                new Student("Попов", "Владимир", Arrays.asList(new Lesson("English", 2), new Lesson("Philosophy", 6), new Lesson("History", 3))),
                new Student("Лебедев", "Петр", Arrays.asList(new Lesson("English", 7), new Lesson("Philosophy", 2), new Lesson("History", 8)))
        ), "technologyAndOrganization");
        Group accounting = new Group(Arrays.asList(
                new Student("Соколов", "Станислав", Arrays.asList(new Lesson("English", 4), new Lesson("Philosophy", 2), new Lesson("History", 8))),
                new Student("Иванов", "Михаил", Arrays.asList(new Lesson("English", 10), new Lesson("Philosophy", 7), new Lesson("History", 9)))
        ), "accounting");
        Group customsService = new Group(Arrays.asList(
                new Student("Смирнов", "Сергей", Arrays.asList(new Lesson("English", 3), new Lesson("Philosophy", 6), new Lesson("History", 7))),
                new Student("Кузнецов", "Александр", Arrays.asList(new Lesson("English", 8), new Lesson("Philosophy", 3), new Lesson("History", 5)))
        ), "customsService");
        Group historyAndPoliticalScience = new Group(Arrays.asList(
                new Student("Козлов", "Дмитрий", Arrays.asList(new Lesson("English", 7), new Lesson("Philosophy", 5), new Lesson("History", 2))),
                new Student("Джавович", "Арсен", Arrays.asList(new Lesson("English", 4), new Lesson("Philosophy", 4), new Lesson("History", 3)))
        ), "historyAndPoliticalScience");

        civilEngineeringGroups.add(architecture);
        civilEngineeringGroups.add(reconstruction);
        economicGroups.add(technologyAndOrganization);
        economicGroups.add(accounting);
        mechanicalGroups.add(customsService);
        mechanicalGroups.add(historyAndPoliticalScience);

        Faculty civilEngineering = new Faculty(civilEngineeringGroups, "civilEngineering");
        Faculty economic = new Faculty(economicGroups, "economic");
        Faculty mechanical = new Faculty(mechanicalGroups, "mechanical");
        List<Faculty> faculties = new ArrayList<>();
        faculties.add(mechanical);
        faculties.add(civilEngineering);
        faculties.add(economic);

        University belSut = new University(faculties);

        System.out.printf("%.2f%n", belSut.getStudentAverageMark("Джавович"));

        System.out.println(belSut.getLessonsAverageMark("Philosophy"));
        System.out.println(belSut.getMarksFromParticularGroupAndFaculty("English", "civilEngineering", "architecture"));
    }
}
