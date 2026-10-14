package org.example;

public class ShapeController {
    private Shape[] model;
    private ShapeView view;
    private ShapeService service;

    public ShapeController(Shape[] model, ShapeView view, ShapeService service) {
        this.model = model;
        this.view = view;
        this.service = service;
    }

    public void execute() {
        view.printMessage("=== Вихідний набір даних ===");
        view.printShapes(model);

        view.printMessage("=== Сумарна площа всіх фігур ===");
        view.printMessage(String.format("%.2f\n", service.calcTotalArea(model)));

        view.printMessage("=== Сумарна площа всіх Кіл ===");
        view.printMessage(String.format("%.2f\n", service.calcTotalAreaByType(model, Circle.class)));

        view.printMessage("=== Набір даних, відсортований за площею (зростання) ===");
        service.sortByArea(model);
        view.printShapes(model);

        view.printMessage("=== Набір даних, відсортований за кольором ===");
        service.sortByColor(model);
        view.printShapes(model);
    }
}
