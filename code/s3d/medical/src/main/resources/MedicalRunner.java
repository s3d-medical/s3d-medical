
import org.mortbay.jetty.Server;
import org.mortbay.jetty.webapp.WebAppContext;

public class MedicalRunner {
	public static void main(String[] args) throws Exception {

		Server server = new Server(80);

		WebAppContext context1 = new WebAppContext();

		context1.setDescriptor("d:/java/workspace/medical/WebContent/WEB-INF/web.xml");
		context1.setResourceBase("d:/java/workspace/medical/WebContent");
		context1.setContextPath("/medical");

		context1.setParentLoaderPriority(true);

		server.setHandler(context1);

		server.start();

		server.join();

		// System.out.println("---------");
		// Server server = new Server();
		// Connector connector = new SelectChannelConnector();
		// connector.setPort(80); // 设置要监听的端口.
		// server.addConnector(connector);
		// WebAppContext context = new WebAppContext();
		// context.setContextPath("/medical"); // 设置上下文路径
		// context.setResourceBase("d:/java/workspace/medical/WebContent");//
		// 设置web应用根路径
		//
		// HandlerCollection handlerCollection = new HandlerCollection();
		// handlerCollection.addHandler(context);
		// server.setHandler(handlerCollection);
		// server.start();
		// server.join();
	}
}
