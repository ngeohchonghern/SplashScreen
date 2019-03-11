package com.raymondyang.constraintlayouttesting

object DataManager {
    val imagesUrl = ArrayList<ImageData>()

    init {
        initializeImagesUrl()

    }

    private fun initializeImagesUrl() {
        var image = ImageData("https://i.ibb.co/G0ZzCC6/Mountains-Lake-Canada-Men-Scenery-Canadian-Rocky-559181-720x1280.jpg", "Mountains")
        imagesUrl.add(image)
        image = ImageData("https://i.ibb.co/k94B7cF/beautiful-scenery-mountains-lake-nature-93318-720x1280.jpg", "Lake")
        imagesUrl.add(image)
        image = ImageData("https://i.ibb.co/1TRHb9J/Jiuzhaigou-park-China-Parks-Lake-Mountains-Forests-524007-720x1280.jpg", "Jiuzhaigou")
        imagesUrl.add(image)
        image = ImageData("https://i.ibb.co/7gfxrYC/England-Scenery-Sunrises-and-sunsets-Coast-Stones-527331-720x1280.jpg", "Sunrises")
        imagesUrl.add(image)
        image = ImageData("https://i.ibb.co/XbjznZS/Grand-Canyon-Park-USA-Mountains-Sunrises-and-559112-720x1280.jpg", "Canyon")
        imagesUrl.add(image)
        image = ImageData("https://i.ibb.co/ZWbSsrm/Scenery-Fields-Lavandula-Sky-Camomiles-Clouds-523500-720x1280.jpg", "Lavandula")
        imagesUrl.add(image)
        image = ImageData("https://i.ibb.co/mbYGpYq/Scenery-Mountains-Lake-Moon-Night-Reflection-518851-720x1280.jpg", "Moon")
        imagesUrl.add(image)
        image = ImageData("https://i.ibb.co/qyfZTFj/Scenery-Sunrises-and-sunsets-Sky-Fields-Clouds-535656-720x1280.jpg", "Clouds")
        imagesUrl.add(image)
        image = ImageData("https://i.ibb.co/F5017zQ/USA-Coast-Sunrises-and-sunsets-Scenery-Stones-Sky-541859-720x1280.jpg", "Stones")
        imagesUrl.add(image)
        image = ImageData("https://i.ibb.co/6FjLkbr/Waterfalls-Rivers-Scenery-Canada-Stones-Forests-527878-720x1280.jpg", "Waterfalls")
        imagesUrl.add(image)
//        imagesUrl.add()
////        imagesUrl.add("https://i.ibb.co/7gfxrYC/England-Scenery-Sunrises-and-sunsets-Coast-Stones-527331-720x1280.jpg")
////        imagesUrl.add("https://i.ibb.co/XbjznZS/Grand-Canyon-Park-USA-Mountains-Sunrises-and-559112-720x1280.jpg")
////        imagesUrl.add("https://i.ibb.co/1TRHb9J/Jiuzhaigou-park-China-Parks-Lake-Mountains-Forests-524007-720x1280.jpg")
//        imagesUrl.add("https://i.ibb.co/ZWbSsrm/Scenery-Fields-Lavandula-Sky-Camomiles-Clouds-523500-720x1280.jpg")
//        imagesUrl.add("https://i.ibb.co/mbYGpYq/Scenery-Mountains-Lake-Moon-Night-Reflection-518851-720x1280.jpg")
//        imagesUrl.add("https://i.ibb.co/qyfZTFj/Scenery-Sunrises-and-sunsets-Sky-Fields-Clouds-535656-720x1280.jpg")
//        imagesUrl.add("https://i.ibb.co/F5017zQ/USA-Coast-Sunrises-and-sunsets-Scenery-Stones-Sky-541859-720x1280.jpg")
//        imagesUrl.add("https://i.ibb.co/6FjLkbr/Waterfalls-Rivers-Scenery-Canada-Stones-Forests-527878-720x1280.jpg")


    }
}