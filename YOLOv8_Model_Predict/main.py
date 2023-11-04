from ultralytics import YOLO

# Load a pretrained YOLOv8n model
model = YOLO('best.pt')

# Run inference on 'bus.jpg' with arguments
# model.predict('quy-dinh-cach-lap-dat-bien-bao-giao-thong.jpg', save=True, imgsz=640, conf=0.7)

model.predict(source="0", show=True, conf=0.7)

