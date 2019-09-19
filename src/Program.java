
	import javafx.application.*;
	import javafx.stage.Stage;
	public class Program extends Application {

		public static void main(String[] args)  {
	launch(args);
		}

		@Override
		public void start(Stage primaryStage) throws Exception {
			model.Model model = new model.Model();
			view.View view = new view.View(primaryStage);
			controller.Controller controller = new controller.Controller(view, model);
		}

	}
